package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoQueryBubble$QueryBubbleInfoResp extends MessageMicro<TVideoQueryBubble$QueryBubbleInfoResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"code", "msg", "data"}, new Object[]{0, "", null}, TVideoQueryBubble$QueryBubbleInfoResp.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f437775msg = PBField.initString("");
    public TVideoQueryBubble$QueryBubbleInfoData data = new TVideoQueryBubble$QueryBubbleInfoData();
}
