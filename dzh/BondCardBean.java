// 看到多种不同类型，首先想到枚举，对于不同的情况处理不同，可以使用策略设计模式。
public class BondCardBean {
    private String type; // 债券类型字段

    public String getType() {
        return type;
    }

    List<CardField> fields; // 需展示的属性字段合集
}

// 定义策略处理接口
public interface BondCardProcessor {
    void process(BondCardBean bondCard);
}

// 策略类实现
public class OrdinaryBondCardProcessor implements BondCardProcessor {
    @Override
    public void process(BondCardBean bondCard) {
        displayOrdinaryInfo(bondCard);
    }
}

public class CityInvestmentBondCardProcessor implements BondCardProcessor {
    @Override
    public void process(BondCardBean bondCard) {
        displayCityInvestmentInfo(bondCard);
    }
}

public class ConvertibleBondCardProcessor implements BondCardProcessor {
    @Override
    public void process(BondCardBean bondCard) {
        displayConvertibleInfo(bondCard);
    }
}

// 默认处理类
public class DefaultBondCardProcessor implements BondCardProcessor {
    @Override
    public void process(BondCardBean bondCard) {
        displayDefaultInfo(bondCard);
    }
}

// 工厂类
public class BondCardProcessorFactory {
    private static final Map<String, BondCardProcessor> PROCESSORS = new HashMap<>();

    static {
        PROCESSORS.put("ORDINARY", new OrdinaryBondCardProcessor());
        PROCESSORS.put("CITY_INVESTMENT", new CityInvestmentBondCardProcessor());
        PROCESSORS.put("CONVERTIBLE", new ConvertibleBondCardProcessor());
    }

    public static BondCardProcessor getProcessor(String type) {
        return PROCESSORS.getOrDefault(type, new DefaultBondCardProcessor());
    }
}

public void processCardData(BondCardBean bondCard) {
    BondCardProcessor processor = BondCardProcessorFactory.getProcessor(bondCard.getType());
    processor.process(bondCard);
} // 还可以定义BondCardEnum
