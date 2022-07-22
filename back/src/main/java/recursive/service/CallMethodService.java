package recursive.service;

import steps.MyStepdefs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CallMethodService {
    public void using(String methodName, List<String> params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<MyStepdefs> clazz = MyStepdefs.class;
        Class<String>[] stringClasses = new Class[params.size()];
        Arrays.fill(stringClasses, String.class);
        MyStepdefs myStepdefs = new MyStepdefs();
        Method method = clazz.getMethod(methodName, stringClasses);
        method.invoke(myStepdefs, params.toArray());
    }
}
