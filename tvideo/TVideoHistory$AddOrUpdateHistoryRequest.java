package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoHistory$AddOrUpdateHistoryRequest extends MessageMicro<TVideoHistory$AddOrUpdateHistoryRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"data_version", "video_history_records"}, new Object[]{0L, null}, TVideoHistory$AddOrUpdateHistoryRequest.class);
    public final PBInt64Field data_version = PBField.initInt64(0);
    public final PBRepeatMessageField<TVideoHistory$VideoHistoryRecord> video_history_records = PBField.initRepeatMessage(TVideoHistory$VideoHistoryRecord.class);
}
