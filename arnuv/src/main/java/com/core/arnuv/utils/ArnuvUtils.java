package com.core.arnuv.utils;

import com.core.arnuv.jwt.IJwtService;
import com.core.arnuv.jwt.JwtServiceImpl;
import com.core.arnuv.model.Usuariodetalle;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Component
public class ArnuvUtils {

    public static <T> Collection convertirLista(List lsource, Class<T> destinationType, String... excludedProperties) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        if (excludedProperties != null) {
            List<String> exclusiones = Arrays.asList(excludedProperties);
            modelMapper.getConfiguration().setPropertyCondition(context ->
                    !exclusiones.contains(context.getMapping().getLastDestinationProperty().getName()));
        }

        return lsource.stream().map(o -> (T) modelMapper.map(o, destinationType)).toList();
    }

    public static <T> T convertirObjeto(Object source, Class<T> destinationType, String... excludedProperties) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        List<String> exclusiones = Arrays.asList(excludedProperties);
        modelMapper.getConfiguration().setPropertyCondition(context ->
                !exclusiones.contains(context.getMapping().getLastDestinationProperty().getName()));

        return modelMapper.map(source, destinationType);
    }

}
