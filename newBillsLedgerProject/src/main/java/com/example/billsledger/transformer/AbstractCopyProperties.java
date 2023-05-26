package com.example.billsledger.transformer;

import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCopyProperties<Origin, Destination> {

    protected final Class<Destination> destinationClass;
    protected final Class<Origin> sourceClass;

    @SuppressWarnings("unchecked")
    public AbstractCopyProperties() {
        super();
        this.sourceClass = (Class<Origin>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.destinationClass = (Class<Destination>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @SneakyThrows
    public Destination dtoToEntity(final Origin orig) {
        final Destination destination = destinationClass.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(orig, destination);
        return destination;
    }

    @SneakyThrows
    public Destination entityToDto(final Origin orig) {
        final Destination destination = destinationClass.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(orig, destination);
        return destination;
    }

    @SneakyThrows
    public List<Destination> entityToDto(final List<Origin> orig) {
        List<Destination> destinations = new ArrayList<Destination>();
        destinations = orig.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
        return destinations;
    }
}
