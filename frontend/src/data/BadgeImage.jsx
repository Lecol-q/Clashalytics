import {getBadgeById} from "./clanBadgeLookUp.js";
import "./BadgeImage.css"

function BadgeImage({ id }) {
    const badge = getBadgeById(id);

    if(!badge) return null;

    return (
        <img
            className="clanBadge"
            src={`/badges/${badge.name}.png`}
            alt={badge.name}
        />
    );
}

export default BadgeImage;