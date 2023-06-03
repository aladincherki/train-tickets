package traintickets.commun.converter;

import javax.persistence.*;
import traintickets.commun.enums.TrainTypeEnum;

@Converter(autoApply = true)
public class TrainTypeConverter implements AttributeConverter<TrainTypeEnum, Integer> {

	@Override
	public Integer convertToDatabaseColumn(TrainTypeEnum attribute) {
		if(attribute == null) 
			return null;
		switch(attribute) {
		case ATLAS:
			return 1;
		case TL:
			return 2;
		default:
            throw new IllegalArgumentException(attribute + " not supported.");		
		}

	}

	@Override
	public TrainTypeEnum convertToEntityAttribute(Integer dbData) {
		if(dbData == null) 
			return null;
		switch(dbData) {
		case 1:
			return TrainTypeEnum.ATLAS;
		case 2:
			return TrainTypeEnum.TL;
		default:
            throw new IllegalArgumentException(dbData + " not supported.");
		}

	}



}
