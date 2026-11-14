import badges from "./clanBadges.json";

const badgeMap = new Map(
    badges.map(badge => [badge.id, badge]));

export function getBadgeById(id) {
    return badgeMap.get(id);
}