package cat.dme.ornitho.server.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Note: Date/GregorianCalendar are serialized as ISO-8601
 *
 */
public class JSONUtil {

	private static ObjectMapper mapper = JSONUtil.jacksonObjectMapper();

	/**
	 *
	 * @return the bean that configures the mapping jackson 2 http
	 */
	public static ObjectMapper jacksonObjectMapper() {

		final ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		// This will use ISO-8601
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		// TO REVIEW: DATES!!

		// objectMapper.setDateFormat(ConfigConstants.JSON_DATE_TIME_FORMAT);
		//
		// JavaTimeModule jtm = new JavaTimeModule();
		// //jtm.addSerializer(LocalTime.class, new
		// LocalTimeSerializer(TimeUtils.DTFTime));
		// jtm.addDeserializer(LocalDate.class, CustomLocalDateDeserializer.INSTANCE);
		// objectMapper.registerModule(jtm);

		// TODO maybe it can tun
		// Really remove this
		// SimpleModule module= new SimpleModule();
		// module.addDeserializer(String.class, new SanitizedStringDeserializer() );
		// objectMapper.registerModule(module);

		return objectMapper;
	}

	public static File convertObjectToJsonFile(final String pathFileJson, final Object obj)
			throws JsonGenerationException, JsonMappingException, IOException {

		// Object to JSON in file
		final File fileJson = new File(pathFileJson);
		JSONUtil.mapper.writeValue(fileJson, obj);

		return fileJson;
	}

	public static String convertObjectToJsonString(final Object obj) throws JsonProcessingException {

		// Object to JSON in String
		final String strJson = JSONUtil.mapper.writeValueAsString(obj);

		return strJson;
	}

	public static Object convertJsonFileToObject(final String pathFileJson, final Class<?> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		// JSON from file to Object
		final File fileJson = new File(pathFileJson);
		final Object obj = JSONUtil.mapper.readValue(fileJson, clazz);

		return obj;
	}

	public static Object convertJsonURLToObject(final String urlSpec, final Class<?> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		// JSON from URL to Object
		final URL url = new URL(urlSpec);
		final Object obj = JSONUtil.mapper.readValue(url, clazz);

		return obj;
	}

	public static Object convertJsonStringToObject(final String strJson, final Class<?> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		// JSON from String to Object
		final Object obj = JSONUtil.mapper.readValue(strJson, clazz);

		return obj;
	}

	public static Object convertJsonStringToParametrizedObject(final String strJson, final Class<?> cParametrized,
			final Class<?>... cParameterClasses) throws JsonParseException, JsonMappingException, IOException {

		// JSON from String to Parametrized Object
		final JavaType valueType = JSONUtil.mapper.getTypeFactory().constructParametricType(cParametrized, cParameterClasses);
		final Object obj = JSONUtil.mapper.readValue(strJson, valueType);

		return obj;
	}

	/**
	 * Easy, with unchecked exceptions, json string to parametrized object
	 *
	 * @param strJson,
	 *            jason string
	 * @param cParametrized,
	 *            target class
	 * @param cParameterClasses,
	 *            classes for the generic types
	 * @return
	 */
	public static <T> T jsonTo(final String strJson, final Class<T> cParametrized,
			final Class<?>... cParameterClasses) {

		// JSON from String to Parametrized Object
		final JavaType valueType = JSONUtil.mapper.getTypeFactory().constructParametricType(cParametrized, cParameterClasses);
		T obj;
		try {
			obj = JSONUtil.mapper.readValue(strJson, valueType);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		return obj;
	}

	/**
	 * Easy, with unchecked exceptions, json string to parameterized object
	 *
	 * @param jsonFilename,
	 *            jason filename read from resources
	 * @param cParametrized,
	 *            target class
	 * @param cParameterClasses,
	 *            classes for the generic types
	 * @return
	 */
	public static <T> T jsonFileTo(final String jsonFilename, final Class<T> cParametrized,
			final Class<?>... cParameterClasses) {

		final String strJson = FileUtil.readStrFromJsonResourceFile(jsonFilename);

		return JSONUtil.jsonTo(strJson, cParametrized, cParameterClasses);
	}

	public static ObjectMapper getMapper() {
		return JSONUtil.mapper;
	}

}
