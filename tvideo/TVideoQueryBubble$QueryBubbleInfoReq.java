package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoQueryBubble$QueryBubbleInfoReq extends MessageMicro<TVideoQueryBubble$QueryBubbleInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"vid", "cid"}, new Object[]{"", ""}, TVideoQueryBubble$QueryBubbleInfoReq.class);
    public final PBStringField vid = PBField.initString("");
    public final PBStringField cid = PBField.initString("");
}
