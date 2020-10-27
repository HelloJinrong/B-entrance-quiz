package com.thoughtworks.capability.gtb.entrancequiz.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.sun.istack.internal.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Students {
    @NotNull
    private int id;
    @NotNull
    private String name;
}
