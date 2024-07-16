package in.urbanecart.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {
	private String message;
	private T data;
	
	@SuppressWarnings("unchecked")
	public ResponseData(String message, List<? extends Object> dataList) {
	    this.message = message;
	    this.data = (T) dataList;
	}

}
