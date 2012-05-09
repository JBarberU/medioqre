package factory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import core.JSONSerializable;

public class Level implements JSONSerializable {
	// Model part
	private String		playerData		= "gamedata/player.json";
	private String		enemyData		= "gamedata/enemy.json";
	private String		itemData		= "gamedata/items.json";
	private String		weaponData		= "gamedata/weapons.json";
	private String		worldData		= "gamedata/world.json";
	private String		levelData		= "gamedata/levels/default.json";

	// View part
	// .act is an abbreviation for actor data
	private String[]	actorsData		= { "spritesheets/json/frank.act",
			"spritesheets/json/walker1.act", "spritesheets/json/gameitems.act",
			"spritesheets/json/machinegun_projectile.act",
			"spritesheets/json/portal.act", };
	private String		tileMapData		= "spritesheets/levels/level1.lvl";
	
	private String		gameSettings	= "screen.dat";

	public Level()
	{
	}

	public Level(String playerData, String enemyData, String itemData,
			String weaponData, String actorsData[], String levelData,
			String tileMapData, String gameSettings)
	{
		this.playerData = playerData;
		this.enemyData = enemyData;
		this.itemData = itemData;
		this.weaponData = weaponData;
		this.levelData = levelData;

		this.actorsData = actorsData;
		this.tileMapData = tileMapData;
		this.gameSettings = gameSettings;
	}

	// Getters

	public String getPlayerData()
	{
		return this.playerData;
	}

	public String getEnemyData()
	{
		return this.enemyData;
	}

	public String getItemData()
	{
		return this.itemData;
	}

	public String getWeaponData()
	{
		return this.weaponData;
	}

	@Deprecated
	public String getLevelData()
	{
		return this.levelData;
	}

	public String getWorldData()
	{
		return this.worldData;
	}

	public String[] getActorsData()
	{
		return this.actorsData;
	}

	public String getTileMapData()
	{
		return this.tileMapData;
	}

	public String getGameSettingsString()
	{
		return this.gameSettings;
	}

	@Override
	public JSONObject serialize()
	{
		JSONObject retObject = new JSONObject();
		try {
			retObject.put("playerData", this.playerData);
			retObject.put("enemyData", this.enemyData);
			retObject.put("itemData", this.itemData);
			retObject.put("weaponData", this.weaponData);
			retObject.put("levelData", this.levelData);

			retObject.put("actorsData", this.actorsData);
			retObject.put("tileMapData", this.tileMapData);
			retObject.put("gameSettings", this.gameSettings);

			return retObject;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deserialize(JSONObject o)
	{
		try {
			this.playerData = o.getString("playerData");
			this.enemyData = o.getString("enemyData");
			this.itemData = o.getString("itemData");
			this.weaponData = o.getString("weaponData");
			this.levelData = o.getString("levelData");

			JSONArray array = o.getJSONArray("actorsData");
			this.actorsData = new String[array.length()];
			for (int i = 0; i < this.actorsData.length; i++) {
				this.actorsData[i] = array.getString(i);
			}

			this.tileMapData = o.getString("tileMapData");
			this.gameSettings = o.getString("gameSettings");
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
