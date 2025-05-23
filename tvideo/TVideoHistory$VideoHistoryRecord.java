package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoHistory$VideoHistoryRecord extends MessageMicro<TVideoHistory$VideoHistoryRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56, 80, 90}, new String[]{"appid", "record_id", "cid", "vid", "view_date", "video_time", "total_watch_time", "data_version", "from_context"}, new Object[]{"", "", "", "", 0L, 0, 0, 0L, ""}, TVideoHistory$VideoHistoryRecord.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField record_id = PBField.initString("");
    public final PBStringField cid = PBField.initString("");
    public final PBStringField vid = PBField.initString("");
    public final PBInt64Field view_date = PBField.initInt64(0);
    public final PBInt32Field video_time = PBField.initInt32(0);
    public final PBInt32Field total_watch_time = PBField.initInt32(0);
    public final PBInt64Field data_version = PBField.initInt64(0);
    public final PBStringField from_context = PBField.initString("");
}
