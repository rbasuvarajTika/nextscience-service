package com.nextscience.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *  @author Raghu
 * The {@code ResetPassRequestDto} class
 * is used to retrieve from the DB.
 * <br> {@code @Data} annotation is used to generate
 * <br>
 * <i>Getters, Setters, Parameterized Constructor, toString, equals and HashCode methods</i>
 */
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResetPassRequestDto {
	
	String resetlink;
	String toEmail;

}