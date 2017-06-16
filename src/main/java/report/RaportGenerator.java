package report;

import config.Bucket;

import java.util.Date;
import java.util.List;

public class RaportGenerator {
    public String generateRaport(List<Bucket> bucketList,Date generateDate) {
        StringBuilder builder = new StringBuilder();
        builder.append(generateDate);
        builder.append(" Generated Report:\n");
        for (Bucket bucket: bucketList) {
            builder.append(bucket.getStartDate().toString());
            builder.append(" to ");
            builder.append(bucket.getStopDate().toString());
            builder.append("\n");
            builder.append("Adults: ");
            builder.append(bucket.getAdultNumber());
            builder.append(" Children:");
            builder.append(bucket.getChildNumber());
            builder.append("\n");
        }
        return builder.toString();
    }
}
