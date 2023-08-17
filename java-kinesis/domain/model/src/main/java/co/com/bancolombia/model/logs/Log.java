package co.com.bancolombia.model.logs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class Log {

    private String sessionId;
    private String transactionId;
    private BigInteger initialYearTrx;
    private BigInteger initialMonthTrx;
    private BigInteger initialDayTrx;
    private String initialTrxHour;
    private BigInteger finalTrxYear;
    private BigInteger finalTrxMonth;
    private BigInteger finalTrxDay;
    private String finalTrxHour;
    private Date initialDate;
    private Date finalDate;
    private String transactionCode;
    private String transactionCodeDesc;
    private String responseCode;
    private String responseCodeDesc;
    private String technicalCode;
    private String channel;
    private String deviceNameId;
    private String ip;
    private String authenticationType;
    private String currency;
    private BigDecimal localAmount;
    private BigDecimal internationalAmount;
    private BigInteger establishmentUniqueCode;
    private String cardNumber;
    private String originProductType;
    private BigInteger originProductNumber;
    private String destinyProductType;
    private BigInteger destinyProductNumber;
    private String destinyProductRelation;
    private String transactionMode;
    private BigInteger transactionVoucherNumber;
    private String destinyBankCode;
    private String originBankCode;
    private BigInteger agreementCode;
    private String reference;
    private String transactionType;
    private String inputTransactionMode;
    private String transactionState;
    private String commission;
    private BigDecimal transactionValule;
    private BigInteger throwbackId;
    private String latitude;
    private String length;
    private String documentTypeCode;
    private String documentType;
    private String documentNumber;
    private String customerName;
    private String authorizedUserdocumentTypeCode;
    private String authorizedUserdocumentType;
    private String authorizedUserdocumentNumber;
    private String authorizedUserName;
    private String brandModel;
    private String osVersion;
    private String browser;
    private String mobileOperator;
    private String appVersion;
    private String sharedKey;
    private String agreementTermsConditions;
    private BigDecimal versionTermsConditions;
    private BigInteger agreementTermsConditionsDate;
    private BigDecimal value1;
    private BigDecimal value2;
    private BigDecimal value3;
    private BigDecimal value4;
    private BigDecimal value5;
    private BigDecimal value6;
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private String field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;

    public static Log newLog() {
        return Log.builder()
                .sessionId(UUID.randomUUID().toString())
                .transactionId("transactionId")
                .initialYearTrx(BigInteger.ONE)
                .initialMonthTrx(BigInteger.ONE)
                .initialDayTrx(BigInteger.ONE)
                .initialTrxHour("initialTrxHour")
                .finalTrxYear(BigInteger.ONE)
                .finalTrxMonth(BigInteger.ONE)
                .finalTrxDay(BigInteger.ONE)
                .finalTrxHour("finalTrxHour")
                .initialDate(new Date())
                .finalDate(new Date())
                .transactionCode("transactionCode")
                .transactionCodeDesc("transactionCodeDesc")
                .responseCode("responseCode")
                .responseCodeDesc("responseCodeDesc")
                .technicalCode("technicalCode")
                .channel("channel")
                .deviceNameId("deviceNameId")
                .ip("ip")
                .authenticationType("authenticationType")
                .currency("currency")
                .localAmount(BigDecimal.ONE)
                .internationalAmount(BigDecimal.ONE)
                .establishmentUniqueCode(BigInteger.ONE)
                .cardNumber("cardNumber")
                .originProductType("originProductType")
                .originProductNumber(BigInteger.ONE)
                .destinyProductType("destinyProductType")
                .destinyProductNumber(BigInteger.ONE)
                .destinyProductRelation("destinyProductRelation")
                .transactionMode("transactionMode")
                .transactionVoucherNumber(BigInteger.ONE)
                .destinyBankCode("destinyBankCode")
                .originBankCode("originBankCode")
                .agreementCode(BigInteger.ONE)
                .reference("reference")
                .transactionType("transactionType")
                .inputTransactionMode("inputTransactionMode")
                .transactionState("transactionState")
                .commission("commission")
                .transactionValule(BigDecimal.ONE)
                .throwbackId(BigInteger.ONE)
                .latitude("latitude")
                .length("length")
                .documentTypeCode("documentTypeCode")
                .documentType("documentType")
                .documentNumber("documentNumber")
                .customerName("customerName")
                .authorizedUserdocumentTypeCode("authorizedUserdocumentTypeCode")
                .authorizedUserdocumentType("authorizedUserdocumentType")
                .authorizedUserdocumentNumber("authorizedUserdocumentNumber")
                .authorizedUserName("authorizedUserName")
                .brandModel("brandModel")
                .osVersion("osVersion")
                .browser("browser")
                .mobileOperator("mobileOperator")
                .appVersion("appVersion")
                .sharedKey("sharedKey")
                .agreementTermsConditions("agreementTermsConditions")
                .versionTermsConditions(BigDecimal.ONE)
                .agreementTermsConditionsDate(BigInteger.ONE)
                .value1(BigDecimal.ONE)
                .value2(BigDecimal.ONE)
                .value3(BigDecimal.ONE)
                .value4(BigDecimal.ONE)
                .value5(BigDecimal.ONE)
                .value6(BigDecimal.ONE)
                .field1("field1")
                .field2("field2")
                .field3("field3")
                .field4("field4")
                .field5("field5")
                .field6("field6")
                .field7("field7")
                .field8("field8")
                .field9("field9")
                .build();
    }
}
