/*
package ru.javarush.drogunov.wildisland.util;

import lombok.SneakyThrows;
import ru.javarush.drogunov.wildisland.enity.annotations.Initialize;
import ru.javarush.drogunov.wildisland.exceptions.ClassForDependenceNotFound;
import ru.javarush.drogunov.wildisland.game_space.GameSettings;
import ru.javarush.drogunov.wildisland.game_space.GameSpace;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Injector {
    private static Map<Class<?>, Class<?>> beans = new HashMap<>();

    static {
        beans.put(InitializerGame.class, InitializerGame.class);
        beans.put(GameSpace.class, GameSpace.class);
        beans.put(GameSettings.class, GameSettings.class);
        beans.put(StartPopulation.class, StartPopulation.class);
        beans.put(FabricGameUnit.class, FabricGameUnit.class);
    }

    @SneakyThrows
    public static Object injectDependencies(Class<?> clazz) {
//        Object newObject = clazz.getConstructor().newInstance();
        Object newObject = null;

        for (Field declaredField : */
/*newObject.getClass()*//*
clazz.getDeclaredFields()) {
            if (declaredField.isAnnotationPresent(Initialize.class)) {
                Class<?> type = declaredField.getType();
                Class<?> injectedClass = beans.get(type);
                if (injectedClass == null) {
                    throw new ClassForDependenceNotFound("Field " + declaredField.getName() + " can't be injected");
                }

                Object injectingInstance = injectDependencies(injectedClass);
                newObject = clazz.getConstructor().newInstance();
                declaredField.setAccessible(true);
                declaredField.set(newObject, injectingInstance);
                declaredField.setAccessible(false);
            }
        }
        return newObject;
    }
}
*/
//TODO удалить