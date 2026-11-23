package org.example.notNeedClasses.aop.introduction;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class IsModifiedMixin extends DelegatingIntroductionInterceptor implements IsModified {
    private boolean isModified = false;
    private Map<Method, Method> methodCache = new HashMap();

    @Override
    public boolean isModified() {
        return isModified;
    }

    @Nullable
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        if (!isModified) {
            if (mi.getMethod().getName().startsWith("set") && (mi.getArguments().length == 1)) {
                Method getter = getGetter(mi.getMethod());

                if (getter != null) {
                    Object newValue = mi.getArguments()[0];
                    Object oldValue = getter.invoke(mi.getThis(), null);
                    if (newValue == null && oldValue == null)
                        isModified = false;
                    else if ((newValue == null) && (oldValue != null))
                        isModified = true;
                    else if ((newValue != null) && (oldValue == null))
                        isModified = true;
                    else
                        isModified = !newValue.equals(oldValue);
                }
            }
        }
        return super.invoke(mi);
    }

    private Method getGetter(Method setter) {
        Method getter = methodCache.get(setter);
        if (getter != null)
            return getter;

        String getterName = setter.getName().replaceFirst("set", "get");

        try {
            getter = setter.getDeclaringClass().getMethod(getterName, null);
            synchronized (methodCache) {
                methodCache.put(setter, getter);
            }
            return getter;
        } catch (Exception e) {
            return null;
        }
    }
}
