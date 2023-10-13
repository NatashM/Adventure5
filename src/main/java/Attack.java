public class Attack {
    private Player player;

    public Attack(Player player) {
        this.player = player;
    }

    public AttackEnum attack(Enemy enemy) {
        if (player.getHealthPoint() <= 0) {
            return AttackEnum.PLAYER_DEAD;
        }
        if (enemy.getEnemyHealth() <= 0) {
            return AttackEnum.ENEMY_DEAD;
        }
        int damage = player.getCurrentWeapon().getDamage();
        enemy.reduceHealth(damage);

        if (enemy.getEnemyHealth() <= 0) {
            player.setPlayerHealthPoint(5);
            return AttackEnum.ENEMY_DEAD;
        } else {
            player.reduceHealth(enemy.getDamage());
            return AttackEnum.PLAYER_SUCCESS;
        }
    }
}
