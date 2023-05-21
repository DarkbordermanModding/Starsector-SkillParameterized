package mod.skillparameterized;

import org.json.JSONException;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.skills.AutomatedShips;
import com.fs.starfarer.api.impl.campaign.skills.BallisticMastery;
import com.fs.starfarer.api.impl.campaign.skills.BaseSkillEffectDescription;
import com.fs.starfarer.api.impl.campaign.skills.BestOfTheBest;
import com.fs.starfarer.api.impl.campaign.skills.BulkTransport;
import com.fs.starfarer.api.impl.campaign.skills.CarrierGroup;
import com.fs.starfarer.api.impl.campaign.skills.CombatEndurance;
import com.fs.starfarer.api.impl.campaign.skills.ContainmentProcedures;
import com.fs.starfarer.api.impl.campaign.skills.CoordinatedManeuvers;
import com.fs.starfarer.api.impl.campaign.skills.CrewTraining;
import com.fs.starfarer.api.impl.campaign.skills.CyberneticAugmentation;
import com.fs.starfarer.api.impl.campaign.skills.DamageControl;
import com.fs.starfarer.api.impl.campaign.skills.DerelictContingent;
import com.fs.starfarer.api.impl.campaign.skills.ElectronicWarfare;
import com.fs.starfarer.api.impl.campaign.skills.EnergyWeaponMastery;
import com.fs.starfarer.api.impl.campaign.skills.FieldModulation;
import com.fs.starfarer.api.impl.campaign.skills.FighterUplink;
import com.fs.starfarer.api.impl.campaign.skills.FluxRegulation;
import com.fs.starfarer.api.impl.campaign.skills.GunneryImplants;
import com.fs.starfarer.api.impl.campaign.skills.Helmsmanship;
import com.fs.starfarer.api.impl.campaign.skills.HullRestoration;
import com.fs.starfarer.api.impl.campaign.skills.Hypercognition;
import com.fs.starfarer.api.impl.campaign.skills.ImpactMitigation;
import com.fs.starfarer.api.impl.campaign.skills.IndustrialPlanning;
import com.fs.starfarer.api.impl.campaign.skills.MakeshiftEquipment;
import com.fs.starfarer.api.impl.campaign.skills.Navigation;
import com.fs.starfarer.api.impl.campaign.skills.NeuralLinkScript;
import com.fs.starfarer.api.impl.campaign.skills.OfficerManagement;
import com.fs.starfarer.api.impl.campaign.skills.OrdnanceExpertise;
import com.fs.starfarer.api.impl.campaign.skills.PhaseCorps;
import com.fs.starfarer.api.impl.campaign.skills.PointDefense;
import com.fs.starfarer.api.impl.campaign.skills.PolarizedArmor;
import com.fs.starfarer.api.impl.campaign.skills.Salvaging;
import com.fs.starfarer.api.impl.campaign.skills.Sensors;
import com.fs.starfarer.api.impl.campaign.skills.SupportDoctrine;
import com.fs.starfarer.api.impl.campaign.skills.SystemsExpertise;
import com.fs.starfarer.api.impl.campaign.skills.TacticalDrills;
import com.fs.starfarer.api.impl.campaign.skills.WolfpackTactics;


public class SkillPlugin extends BaseModPlugin {
  private float loadFloat(String skillName, String skillKey){
    try{
      return (float)Global.getSettings().getJSONObject(skillName).getDouble(skillKey);
    } catch (JSONException e){
      throw new RuntimeException("Fail to load skill" + skillName);
    }
  }

  private int loadInt(String skillName, String skillKey){
    try{
      return Global.getSettings().getJSONObject(skillName).getInt(skillKey);
    } catch (JSONException e){
      throw new RuntimeException("Fail to load skill" + skillName);
    }
  }

  // Load when Starsector initialized, before game
  public void onApplicationLoad() {
    // Shared
    BaseSkillEffectDescription.FIGHTER_BAYS_THRESHOLD = loadFloat("Shared", "FIGHTER_BAYS_THRESHOLD");
    BaseSkillEffectDescription.OP_THRESHOLD = loadFloat("Shared", "OP_THRESHOLD");
    BaseSkillEffectDescription.OP_ALL_THRESHOLD = loadFloat("Shared", "OP_ALL_THRESHOLD");

    // Combat
    Helmsmanship.MANEUVERABILITY_BONUS = loadFloat("Helmsmanship", "MANEUVERABILITY_BONUS");
    Helmsmanship.SPEED_BONUS = loadFloat("Helmsmanship", "SPEED_BONUS");
    Helmsmanship.ELITE_SPEED_BONUS_FLAT = loadFloat("Helmsmanship", "ELITE_SPEED_BONUS_FLAT");
    Helmsmanship.ZERO_FLUX_LEVEL = loadFloat("Helmsmanship", "ZERO_FLUX_LEVEL");

    CombatEndurance.PEAK_TIME_BONUS = loadFloat("CombatEndurance", "PEAK_TIME_BONUS");
    CombatEndurance.DEGRADE_REDUCTION_PERCENT = loadFloat("CombatEndurance", "DEGRADE_REDUCTION_PERCENT");
    CombatEndurance.MAX_CR_BONUS = loadFloat("CombatEndurance", "MAX_CR_BONUS");
    CombatEndurance.MAX_REGEN_LEVEL = loadFloat("CombatEndurance", "MAX_REGEN_LEVEL");
    CombatEndurance.REGEN_RATE = loadFloat("CombatEndurance", "REGEN_RATE");
    CombatEndurance.TOTAL_REGEN_MAX_POINTS = loadFloat("CombatEndurance", "TOTAL_REGEN_MAX_POINTS");
    CombatEndurance.TOTAL_REGEN_MAX_HULL_FRACTION = loadFloat("CombatEndurance", "TOTAL_REGEN_MAX_HULL_FRACTION");

    ImpactMitigation.MANEUVERABILITY_BONUS_LARGE = loadFloat("ImpactMitigation", "MANEUVERABILITY_BONUS_LARGE");
    ImpactMitigation.MANEUVERABILITY_BONUS_SMALL = loadFloat("ImpactMitigation", "MANEUVERABILITY_BONUS_SMALL");
    ImpactMitigation.MAX_DAMAGE_REDUCTION_BONUS = loadFloat("ImpactMitigation", "MAX_DAMAGE_REDUCTION_BONUS");
    ImpactMitigation.ARMOR_DAMAGE_REDUCTION = loadFloat("ImpactMitigation", "ARMOR_DAMAGE_REDUCTION");
    ImpactMitigation.ARMOR_KINETIC_REDUCTION = loadFloat("ImpactMitigation", "ARMOR_KINETIC_REDUCTION");
    ImpactMitigation.DAMAGE_TO_MODULES_REDUCTION = loadFloat("ImpactMitigation", "DAMAGE_TO_MODULES_REDUCTION");

    DamageControl.SECONDS_PER_PROC = loadFloat("DamageControl", "SECONDS_PER_PROC");
    DamageControl.INSTA_REPAIR = loadFloat("DamageControl", "INSTA_REPAIR");
    DamageControl.CREW_LOSS_REDUCTION = loadFloat("DamageControl", "CREW_LOSS_REDUCTION");
    DamageControl.MODULE_REPAIR_BONUS = loadFloat("DamageControl", "MODULE_REPAIR_BONUS");
    DamageControl.HULL_DAMAGE_REDUCTION = loadFloat("DamageControl", "HULL_DAMAGE_REDUCTION");
    DamageControl.ELITE_DAMAGE_THRESHOLD = loadFloat("DamageControl", "ELITE_DAMAGE_THRESHOLD");
    DamageControl.ELITE_DAMAGE_REDUCTION_PERCENT = loadFloat("DamageControl", "ELITE_DAMAGE_REDUCTION_PERCENT");

    FieldModulation.SHIELD_DAMAGE_REDUCTION = loadFloat("FieldModulation", "SHIELD_DAMAGE_REDUCTION");
    FieldModulation.FLUX_SHUNT_DISSIPATION = loadFloat("FieldModulation", "FLUX_SHUNT_DISSIPATION");
    FieldModulation.PHASE_FLUX_UPKEEP_REDUCTION = loadFloat("FieldModulation", "PHASE_FLUX_UPKEEP_REDUCTION");
    FieldModulation.PHASE_COOLDOWN_REDUCTION = loadFloat("FieldModulation", "PHASE_COOLDOWN_REDUCTION");

    PointDefense.FIGHTER_DAMAGE_BONUS = loadFloat("PointDefense", "FIGHTER_DAMAGE_BONUS");
    PointDefense.MISSILE_DAMAGE_BONUS = loadFloat("PointDefense", "MISSILE_DAMAGE_BONUS");
    PointDefense.PD_RANGE_BONUS_FLAT = loadFloat("PointDefense", "PD_RANGE_BONUS_FLAT");

    BallisticMastery.PROJ_SPEED_BONUS = loadFloat("BallisticMastery", "PROJ_SPEED_BONUS");
    BallisticMastery.DAMAGE_BONUS = loadFloat("BallisticMastery", "DAMAGE_BONUS");
    BallisticMastery.RANGE_BONUS = loadFloat("BallisticMastery", "RANGE_BONUS");

    SystemsExpertise.BONUS_CHARGES = loadFloat("SystemsExpertise", "BONUS_CHARGES");
    SystemsExpertise.REGEN_PERCENT = loadFloat("SystemsExpertise", "REGEN_PERCENT");
    SystemsExpertise.SYSTEM_COOLDOWN_REDUCTION_PERCENT = loadFloat("SystemsExpertise", "SYSTEM_COOLDOWN_REDUCTION_PERCENT");
    SystemsExpertise.RANGE_PERCENT = loadFloat("SystemsExpertise", "RANGE_PERCENT");
    SystemsExpertise.PEAK_TIME_BONUS = loadFloat("SystemsExpertise", "PEAK_TIME_BONUS");
    SystemsExpertise.OVERLOAD_REDUCTION = loadFloat("SystemsExpertise", "OVERLOAD_REDUCTION");
    SystemsExpertise.MALFUNCTION_CHANCE_MULT = loadFloat("SystemsExpertise", "MALFUNCTION_CHANCE_MULT");

    // Leadership
    TacticalDrills.DAMAGE_PERCENT = loadFloat("TacticalDrills", "DAMAGE_PERCENT");
    TacticalDrills.ATTACK_BONUS = loadInt("TacticalDrills", "ATTACK_BONUS");
    TacticalDrills.CASUALTIES_MULT = loadFloat("TacticalDrills", "CASUALTIES_MULT");

    CoordinatedManeuvers.NAV_FRIGATES = loadFloat("CoordinatedManeuvers", "NAV_FRIGATES");
    CoordinatedManeuvers.NAV_DESTROYERS = loadFloat("CoordinatedManeuvers", "NAV_DESTROYERS");
    CoordinatedManeuvers.NAV_OTHER = loadFloat("CoordinatedManeuvers", "NAV_OTHER");
    CoordinatedManeuvers.CP_REGEN_FRIGATES = loadFloat("CoordinatedManeuvers", "CP_REGEN_FRIGATES");
    CoordinatedManeuvers.CP_REGEN_DESTROYERS = loadFloat("CoordinatedManeuvers", "CP_REGEN_DESTROYERS");

    WolfpackTactics.DAMAGE_TO_LARGER_BONUS = loadFloat("WolfpackTactics", "DAMAGE_TO_LARGER_BONUS");
    WolfpackTactics.DAMAGE_TO_LARGER_BONUS_DEST = loadFloat("WolfpackTactics", "DAMAGE_TO_LARGER_BONUS_DEST");
    WolfpackTactics.PEAK_TIME_BONUS = loadFloat("WolfpackTactics", "PEAK_TIME_BONUS");
    WolfpackTactics.PEAK_TIME_BONUS_DEST = loadFloat("WolfpackTactics", "PEAK_TIME_BONUS_DEST");

    CrewTraining.CR_PERCENT = loadFloat("CrewTraining", "CR_PERCENT");

    CarrierGroup.REPLACEMENT_RATE_PERCENT = loadFloat("CarrierGroup", "REPLACEMENT_RATE_PERCENT");
    CarrierGroup.OFFICER_MULT = loadFloat("CarrierGroup", "OFFICER_MULT");

    FighterUplink.MAX_SPEED_PERCENT = loadFloat("FighterUplink", "MAX_SPEED_PERCENT");
    FighterUplink.CREW_LOSS_PERCENT = loadFloat("FighterUplink", "CREW_LOSS_PERCENT");
    FighterUplink.TARGET_LEADING_BONUS = loadFloat("FighterUplink", "TARGET_LEADING_BONUS");

    OfficerManagement.NUM_OFFICERS_BONUS = loadFloat("OfficerManagement", "NUM_OFFICERS_BONUS");
    OfficerManagement.CP_BONUS = loadFloat("OfficerManagement", "CP_BONUS");

    BestOfTheBest.EXTRA_MODS = loadInt("BestOfTheBest", "EXTRA_MODS");
    BestOfTheBest.DEPLOYMENT_BONUS = loadFloat("BestOfTheBest", "DEPLOYMENT_BONUS");

    SupportDoctrine.COMMAND_POINT_REGEN_PERCENT = loadFloat("SupportDoctrine", "COMMAND_POINT_REGEN_PERCENT");
    SupportDoctrine.DP_REDUCTION = loadFloat("SupportDoctrine", "DP_REDUCTION");
    SupportDoctrine.DP_REDUCTION_MAX = loadFloat("SupportDoctrine", "DP_REDUCTION_MAX");

    // Technology
    Navigation.TERRAIN_PENALTY_REDUCTION = loadFloat("Navigation", "TERRAIN_PENALTY_REDUCTION");
    Navigation.FLEET_BURN_BONUS = loadFloat("Navigation", "FLEET_BURN_BONUS");
    Navigation.SB_BURN_BONUS = loadFloat("Navigation", "SB_BURN_BONUS");

    Sensors.DETECTED_BONUS = loadFloat("Sensors", "DETECTED_BONUS");
    Sensors.SENSOR_BONUS = loadFloat("Sensors", "SENSOR_BONUS");
    Sensors.SLOW_BURN_BONUS = loadFloat("Sensors", "SLOW_BURN_BONUS");

    GunneryImplants.RECOIL_BONUS = loadFloat("GunneryImplants", "RECOIL_BONUS");
    GunneryImplants.TARGET_LEADING_BONUS = loadFloat("GunneryImplants", "TARGET_LEADING_BONUS");
    GunneryImplants.RANGE_BONUS = loadFloat("GunneryImplants", "RANGE_BONUS");
    GunneryImplants.EW_FRIGATES = loadFloat("GunneryImplants", "EW_FRIGATES");
    GunneryImplants.EW_DESTROYERS = loadFloat("GunneryImplants", "EW_DESTROYERS");
    GunneryImplants.EW_OTHER = loadFloat("GunneryImplants", "EW_OTHER");

    EnergyWeaponMastery.ENERGY_DAMAGE_PERCENT = loadFloat("EnergyWeaponMastery", "ENERGY_DAMAGE_PERCENT");
    EnergyWeaponMastery.MIN_RANGE = loadFloat("EnergyWeaponMastery", "MIN_RANGE");
    EnergyWeaponMastery.MAX_RANGE = loadFloat("EnergyWeaponMastery", "MAX_RANGE");

    ElectronicWarfare.PER_SHIP_BONUS = loadFloat("ElectronicWarfare", "PER_SHIP_BONUS");

    FluxRegulation.VENTS_BONUS = loadInt("FluxRegulation", "VENTS_BONUS");
    FluxRegulation.CAPACITORS_BONUS = loadInt("FluxRegulation", "CAPACITORS_BONUS");
    FluxRegulation.DISSIPATION_PERCENT = loadFloat("FluxRegulation", "DISSIPATION_PERCENT");
    FluxRegulation.CAPACITY_PERCENT = loadFloat("FluxRegulation", "CAPACITY_PERCENT");

    BaseSkillEffectDescription.PHASE_OP_THRESHOLD = loadFloat("PhaseCoilTuning", "PHASE_OP_THRESHOLD");
    PhaseCorps.PHASE_SPEED_BONUS = loadFloat("PhaseCoilTuning", "PHASE_SPEED_BONUS");
    PhaseCorps.PEAK_TIME_BONUS = loadFloat("PhaseCoilTuning", "PEAK_TIME_BONUS");
    PhaseCorps.PHASE_SHIP_SENSOR_BONUS_PERCENT = loadFloat("PhaseCoilTuning", "PHASE_SHIP_SENSOR_BONUS_PERCENT");

    CyberneticAugmentation.MAX_ELITE_SKILLS_BONUS = loadFloat("CyberneticAugmentation", "MAX_ELITE_SKILLS_BONUS");

    NeuralLinkScript.INSTANT_TRANSFER_DP = loadFloat("NeuralLink", "INSTANT_TRANSFER_DP");

    AutomatedShips.MAX_CR_BONUS = loadFloat("AutomatedShips", "MAX_CR_BONUS");
    BaseSkillEffectDescription.AUTOMATED_POINTS_THRESHOLD = loadFloat("AutomatedShips", "AUTOMATED_POINTS_THRESHOLD");

    // Industry
    BulkTransport.CARGO_CAPACITY_MAX_PERCENT = loadFloat("BulkTransport", "CARGO_CAPACITY_MAX_PERCENT");
    BulkTransport.CARGO_CAPACITY_THRESHOLD = loadFloat("BulkTransport", "CARGO_CAPACITY_THRESHOLD");
    BulkTransport.FUEL_CAPACITY_MAX_PERCENT = loadFloat("BulkTransport", "FUEL_CAPACITY_MAX_PERCENT");
    BulkTransport.FUEL_CAPACITY_THRESHOLD = loadFloat("BulkTransport", "FUEL_CAPACITY_THRESHOLD");
    BulkTransport.PERSONNEL_CAPACITY_MAX_PERCENT = loadFloat("BulkTransport", "PERSONNEL_CAPACITY_MAX_PERCENT");
    BulkTransport.PERSONNEL_CAPACITY_THRESHOLD = loadFloat("BulkTransport", "PERSONNEL_CAPACITY_THRESHOLD");
    BulkTransport.BURN_BONUS = loadFloat("BulkTransport", "BURN_BONUS");

    Salvaging.CREW_LOSS_REDUCTION = loadFloat("Salvaging", "CREW_LOSS_REDUCTION");
    Salvaging.SALVAGE_BONUS = loadFloat("Salvaging", "SALVAGE_BONUS");

    OrdnanceExpertise.FLUX_PER_OP = loadFloat("OrdnanceExpertise", "FLUX_PER_OP");
    OrdnanceExpertise.CAP_PER_OP = loadFloat("OrdnanceExpertise", "CAP_PER_OP");

    PolarizedArmor.EFFECTIVE_ARMOR_BONUS = loadFloat("PolarizedArmor", "EFFECTIVE_ARMOR_BONUS");
    PolarizedArmor.EMP_BONUS_PERCENT = loadFloat("PolarizedArmor", "EMP_BONUS_PERCENT");
    PolarizedArmor.VENT_RATE_BONUS = loadFloat("PolarizedArmor", "VENT_RATE_BONUS");
    PolarizedArmor.NON_SHIELD_FLUX_LEVEL = loadFloat("PolarizedArmor", "NON_SHIELD_FLUX_LEVEL");

    ContainmentProcedures.CREW_LOSS_REDUCTION = loadFloat("ContainmentProcedures", "CREW_LOSS_REDUCTION");
    ContainmentProcedures.FUEL_USE_REDUCTION_MAX_PERCENT = loadFloat("ContainmentProcedures", "FUEL_USE_REDUCTION_MAX_PERCENT");
    ContainmentProcedures.FUEL_USE_REDUCTION_MAX_FUEL = loadFloat("ContainmentProcedures", "FUEL_USE_REDUCTION_MAX_FUEL");
    ContainmentProcedures.FUEL_SALVAGE_BONUS = loadFloat("ContainmentProcedures", "FUEL_SALVAGE_BONUS");

    MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_PERCENT = loadFloat("MakeshiftEquipment", "SUPPLY_USE_REDUCTION_MAX_PERCENT");
    MakeshiftEquipment.SUPPLY_USE_REDUCTION_MAX_UNITS = loadFloat("MakeshiftEquipment", "SUPPLY_USE_REDUCTION_MAX_UNITS");
    MakeshiftEquipment.SURVEY_COST_MULT = loadFloat("MakeshiftEquipment", "SURVEY_COST_MULT");

    IndustrialPlanning.SUPPLY_BONUS = loadInt("IndustrialPlanning", "SUPPLY_BONUS");
    IndustrialPlanning.CUSTOM_PRODUCTION_BONUS = loadFloat("IndustrialPlanning", "CUSTOM_PRODUCTION_BONUS");

    HullRestoration.CR_PER_SMOD = loadFloat("HullRestoration", "CR_PER_SMOD");
    HullRestoration.DMOD_AVOID_MAX = loadFloat("HullRestoration", "DMOD_AVOID_MAX");
    HullRestoration.DMOD_AVOID_MIN = loadFloat("HullRestoration", "DMOD_AVOID_MIN");
    HullRestoration.DMOD_AVOID_MIN_DP = loadFloat("HullRestoration", "DMOD_AVOID_MIN_DP");
    HullRestoration.DMOD_AVOID_MAX_DP = loadFloat("HullRestoration", "DMOD_AVOID_MAX_DP");

    DerelictContingent.MINUS_DP_PERCENT_PER_DMOD = loadFloat("DerelictOperations", "MINUS_DP_PERCENT_PER_DMOD");

    // Misc skills
    Hypercognition.ACCESS = loadFloat("Hypercognition", "ACCESS");
    Hypercognition.FLEET_SIZE = loadFloat("Hypercognition", "FLEET_SIZE");
    Hypercognition.DEFEND_BONUS = loadInt("Hypercognition", "DEFEND_BONUS");
    Hypercognition.STABILITY_BONUS = loadFloat("Hypercognition", "STABILITY_BONUS");
  }
}
