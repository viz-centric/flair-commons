package com.project.bi.query.dto;

import com.project.bi.general.Interpretable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.project.bi.query.SQLUtil.sanitize;

/**
 * Holds data related to sorting
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SortDTO implements Interpretable {

    private String featureName;

    private Direction direction = Direction.ASC;

    /**
     * Method that interprets certain statements and facts
     *
     * @return string representing the interpretation
     */
    
    
    @Override
    public String interpret() {
        return sanitize(featureName) + " " + direction.getValue();
    }

    public enum Direction {
        ASC("ASC"), DESC("DESC");

        private final String value;

        Direction(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

	@Override
	public String interpret(String connectionName) {
        return interpret();
	}

	
}
