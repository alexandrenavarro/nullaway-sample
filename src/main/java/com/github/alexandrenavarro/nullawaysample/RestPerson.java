package com.github.alexandrenavarro.nullawaysample;


import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.jilt.Builder;
import org.jilt.BuilderStyle;
import org.jspecify.annotations.Nullable;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder(style = BuilderStyle.STAGED, factoryMethod = "builder", toBuilder = "toBuilder")
public final class RestPerson {
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @Nullable
    private final String middleName;

    public static PersonBuilders.FirstName builder() {
        return PersonBuilder.builder();
    }

}
