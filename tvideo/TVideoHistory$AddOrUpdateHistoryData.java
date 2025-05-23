package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoHistory$AddOrUpdateHistoryData extends MessageMicro<TVideoHistory$AddOrUpdateHistoryData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"data_version", "records"}, new Object[]{0L, null}, TVideoHistory$AddOrUpdateHistoryData.class);
    public final PBInt64Field data_version = PBField.initInt64(0);
    public final PBRepeatMessageField<TVideoHistory$VideoHistoryRespData> records = PBField.initRepeatMessage(TVideoHistory$VideoHistoryRespData.class);
}
