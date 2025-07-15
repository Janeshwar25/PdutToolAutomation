package myproject.QueryProcessor;

public class SqlQueryStorage
{
    public static final
        String sqlQuery1 ="""
            UPDATE benefitPlan SET benPlanEffDate = '2018-01-01', benPlanExpDate = '9999-12-31' WHERE planId IN ('RX01000085') AND benPlanStatus = 'A' AND benPlanEffDate > '2018-01-01';
            UPDATE carrierlobplan SET effectiveDate = '2018-01-01' , expirationDate = '9999-12-31' WHERE planId IN ('RX01000085') AND effectiveDate > '2018-01-01';
            UPDATE benefitPlanTradingPartner SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE beneMaxPeriod SET maximumEffDate = '2018-01-01' , maximumExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND maximumEffDate > '2018-01-01';
            UPDATE benedeductibleperiod SET deductibleEffDate = '2018-01-01', deductibleExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND deductibleEffDate > '2018-01-01';
            UPDATE beneplanaddress SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE beneNetworkSched SET beneNetworkSchedEffDate = '2018-01-01', beneNetworkSchedExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND beneNetworkSchedEffDate > '2018-01-01';
            UPDATE benePlanPhoneNumber SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE benePlanRelationship SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE benePlanSettings SET benPlanEffDate = '2018-01-01', benPlanExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND benPlanEffDate > '2018-01-01';
            UPDATE beneStoplossOOPPeriod SET stoplossOOPEffDate = '2018-01-01', stoplossOOPExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND stoplossOOPEffDate > '2018-01-01';
            UPDATE beneExternalID SET externalIDEffDate = '2018-01-01', externalIDExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND externalIDEffDate > '2018-01-01';
            """;

        static String sqlQuery2 = """ 
                UPDATE benefitPlanCode SET benefitCodeEffDate = '2018-01-01', benefitCodeExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND benefitCodeEffDate > '2018-01-01';
                """;

        static String sqlQuery3 = """
        
                UPDATE beneStandardCompID SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE beneplanperiodsettings SET benPlanEffDate = '2018-01-01', benPlanExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND benPlanEffDate > '2018-01-01';
                UPDATE beneAccumBypassPeriod SET beneAccumBypassEffDate = '2018-01-01', beneAccumBypassExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND beneAccumBypassEffDate > '2018-01-01';
                UPDATE beneBaseRate SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE beneCoinsPeriod SET coinsEffDate = '2018-01-01', coinsExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND coinsEffDate > '2018-01-01';
                UPDATE BeneAttribSched SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneCOCYear SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneCopayPeriod SET copayEffDate = '2018-01-01', copayExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND copayEffDate > '2018-01-01';
                """;

        static String sqlQuery4 = """
                UPDATE BeneCostSharePeriod SET costShareEffDate = '2018-01-01', costShareExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND costShareEffDate > '2018-01-01';
                UPDATE BeneNetworkBaseRate SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneNetworkSchedExternalID SET externalIDEffDate = '2018-01-01', externalIDExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND externalIDEffDate > '2018-01-01';
                UPDATE BeneTierNetworkProvDetail SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneTierNetworkProv SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                """;
        static String sqlQuery5 = """
                UPDATE BenePlanFulfillmentTextPeriod SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                """;


        static String sqlQuery6 = """
                
                UPDATE benefitBundle SET benefitBundleEffDate = '2018-01-01', benefitBundleExpDate = '9999-12-31' WHERE benefitBundleStatus = 'A' AND benefitBundleID IN ('51765352') AND benefitBundleEffDate > '2018-01-01';
                UPDATE benefitBundleActuarialValue SET actuarialValueEffDate = '2018-01-01', actuarialValueExpDate = '9999-12-31' WHERE benefitBundleID IN ('51765352') AND actuarialValueEffDate > '2018-01-01';
                UPDATE benefitBundleExtID SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitBundleID IN ('51765352') AND effectiveDate > '2018-01-01';
                UPDATE benefitBundleOptionExtID SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitBundleID IN ('51765352') AND effectiveDate > '2018-01-01';
                UPDATE benefitBundlePlanAccum SET bundleAccumEffDate = '2018-01-01', bundleAccumExpDate = '9999-12-31' WHERE benefitBundleID IN ('51765352') AND bundleAccumEffDate > '2018-01-01';
                UPDATE benefitBundleStandardCompID SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitBundleID IN ('51765352') AND effectiveDate > '2018-01-01';
                UPDATE benefitBundleCrossControlAccum SET crossControlAccumEffDate = '2018-01-01', crossControlAccumExpDate = '9999-12-31' WHERE benefitBundleID IN ('51765352') AND crossControlAccumEffDate > '2018-01-01';
                UPDATE benefitBundleOption SET effectiveDate = '2018-01-01' WHERE benefitBundleID IN ('51765352') AND effectiveDate > '2018-01-01';
                UPDATE BenefitBundleMarketingName SET effectiveDate = '2018-01-01'  WHERE benefitBundleID IN ('51765352') AND effectiveDate > '2018-01-01';
                """;
        static String sqlQuery7 = """
                UPDATE benefitPlan SET benPlanEffDate = '2018-01-01', benPlanExpDate = '9999-12-31' WHERE planId IN ('RX01000085') AND benPlanStatus = 'A' AND benPlanEffDate > '2018-01-01';
            UPDATE carrierlobplan SET effectiveDate = '2018-01-01' , expirationDate = '9999-12-31' WHERE planId IN ('RX01000085') AND effectiveDate > '2018-01-01';
            UPDATE benefitPlanTradingPartner SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE beneMaxPeriod SET maximumEffDate = '2018-01-01' , maximumExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND maximumEffDate > '2018-01-01';
            UPDATE benedeductibleperiod SET deductibleEffDate = '2018-01-01', deductibleExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND deductibleEffDate > '2018-01-01';
            UPDATE beneplanaddress SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE beneNetworkSched SET beneNetworkSchedEffDate = '2018-01-01', beneNetworkSchedExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND beneNetworkSchedEffDate > '2018-01-01';
            UPDATE benePlanPhoneNumber SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE benePlanRelationship SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
            UPDATE benePlanSettings SET benPlanEffDate = '2018-01-01', benPlanExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND benPlanEffDate > '2018-01-01';
            UPDATE beneStoplossOOPPeriod SET stoplossOOPEffDate = '2018-01-01', stoplossOOPExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND stoplossOOPEffDate > '2018-01-01';
            UPDATE beneExternalID SET externalIDEffDate = '2018-01-01', externalIDExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND externalIDEffDate > '2018-01-01';
            
             UPDATE benefitPlanCode SET benefitCodeEffDate = '2018-01-01', benefitCodeExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND benefitCodeEffDate > '2018-01-01';
             
                UPDATE beneStandardCompID SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE beneplanperiodsettings SET benPlanEffDate = '2018-01-01', benPlanExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND benPlanEffDate > '2018-01-01';
                UPDATE beneAccumBypassPeriod SET beneAccumBypassEffDate = '2018-01-01', beneAccumBypassExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND beneAccumBypassEffDate > '2018-01-01';
                UPDATE beneBaseRate SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE beneCoinsPeriod SET coinsEffDate = '2018-01-01', coinsExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND coinsEffDate > '2018-01-01';
                UPDATE BeneAttribSched SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneCOCYear SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneCopayPeriod SET copayEffDate = '2018-01-01', copayExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND copayEffDate > '2018-01-01';
                
                UPDATE BeneCostSharePeriod SET costShareEffDate = '2018-01-01', costShareExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND costShareEffDate > '2018-01-01';
                UPDATE BeneNetworkBaseRate SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneNetworkSchedExternalID SET externalIDEffDate = '2018-01-01', externalIDExpDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND externalIDEffDate > '2018-01-01';
                UPDATE BeneTierNetworkProvDetail SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                UPDATE BeneTierNetworkProv SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                
                UPDATE BenePlanFulfillmentTextPeriod SET effectiveDate = '2018-01-01', expirationDate = '9999-12-31' WHERE benefitPlanVersionID IN (SELECT DISTINCT benefitPlanVersionID FROM benefitPlan WHERE planId IN ('RX01000085') AND benPlanStatus = 'A') AND effectiveDate > '2018-01-01';
                
                """;
    }

