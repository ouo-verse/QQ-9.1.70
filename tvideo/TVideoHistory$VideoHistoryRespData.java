package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoHistory$VideoHistoryRespData extends MessageMicro<TVideoHistory$VideoHistoryRespData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "msg", "video_history_record"}, new Object[]{0, "", null}, TVideoHistory$VideoHistoryRespData.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437774msg = PBField.initString("");
    public TVideoHistory$VideoHistoryRecord video_history_record = new TVideoHistory$VideoHistoryRecord();
}
