package co.com.coban.aplicacionbancaria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CuentaDTO {
    @NotBlank(message = "El id de la cuenta no puede ser vacío")
    private Long id;
}
