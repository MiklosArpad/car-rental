package com.carrental.mapper;

import com.carrental.model.Make;
import com.carrental.resource.MakeResponseResource;
import org.springframework.stereotype.Component;

@Component
public class MakeToResourceMapper implements Mapper<Make, MakeResponseResource> {

    @Override
    public MakeResponseResource map(Make make) {
        var makeResource = new MakeResponseResource();

        makeResource.setId(make.getId());
        makeResource.setName(make.getName());

        return makeResource;
    }
}
