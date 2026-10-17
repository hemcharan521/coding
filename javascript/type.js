const typeChart = {
  Normal: { strengths: [], weaknesses: ["Fighting"], immunities: ["Ghost"] },
  Fire: {
    strengths: ["Grass", "Ice", "Bug", "Steel"],
    weaknesses: ["Water", "Ground", "Rock"],
    immunities: [],
  },
  Water: {
    strengths: ["Fire", "Ground", "Rock"],
    weaknesses: ["Electric", "Grass"],
    immunities: [],
  },
  Electric: {
    strengths: ["Water", "Flying"],
    weaknesses: ["Ground"],
    immunities: [],
  },
  Grass: {
    strengths: ["Water", "Ground", "Rock"],
    weaknesses: ["Fire", "Ice", "Poison", "Flying", "Bug"],
    immunities: [],
  },
  Ice: {
    strengths: ["Grass", "Ground", "Flying", "Dragon"],
    weaknesses: ["Fire", "Fighting", "Rock", "Steel"],
    immunities: [],
  },
  Fighting: {
    strengths: ["Normal", "Ice", "Rock", "Dark", "Steel"],
    weaknesses: ["Flying", "Psychic", "Fairy"],
    immunities: [],
  },
  Poison: {
    strengths: ["Grass", "Fairy"],
    weaknesses: ["Ground", "Psychic"],
    immunities: [],
  },
  Ground: {
    strengths: ["Fire", "Electric", "Poison", "Rock", "Steel"],
    weaknesses: ["Water", "Grass", "Ice"],
    immunities: ["Electric"],
  },
  Flying: {
    strengths: ["Grass", "Fighting", "Bug"],
    weaknesses: ["Electric", "Ice", "Rock"],
    immunities: ["Ground"],
  },
  Psychic: {
    strengths: ["Fighting", "Poison"],
    weaknesses: ["Bug", "Ghost", "Dark"],
    immunities: [],
  },
  Bug: {
    strengths: ["Grass", "Psychic", "Dark"],
    weaknesses: ["Fire", "Flying", "Rock"],
    immunities: [],
  },
  Rock: {
    strengths: ["Fire", "Ice", "Flying", "Bug"],
    weaknesses: ["Water", "Grass", "Fighting", "Ground", "Steel"],
    immunities: [],
  },
  Ghost: {
    strengths: ["Psychic", "Ghost"],
    weaknesses: ["Ghost", "Dark"],
    immunities: ["Normal", "Fighting"],
  },
  Dragon: {
    strengths: ["Dragon"],
    weaknesses: ["Ice", "Dragon", "Fairy"],
    immunities: [],
  },
  Dark: {
    strengths: ["Psychic", "Ghost"],
    weaknesses: ["Fighting", "Bug", "Fairy"],
    immunities: ["Psychic"],
  },
  Steel: {
    strengths: ["Ice", "Rock", "Fairy"],
    weaknesses: ["Fire", "Fighting", "Ground"],
    immunities: ["Poison"],
  },
  Fairy: {
    strengths: ["Fighting", "Dragon", "Dark"],
    weaknesses: ["Poison", "Steel"],
    immunities: ["Dragon"],
  },
};
