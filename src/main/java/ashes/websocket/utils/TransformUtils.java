package ashes.websocket.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;
import java.util.stream.Stream;

@Component
public class TransformUtils {
    public static void copyPropertiesNotNull(Object source, Object target) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        String[] nullNames = Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
        BeanUtils.copyProperties(source, target, nullNames);
    }
}
