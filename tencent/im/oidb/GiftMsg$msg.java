package tencent.im.oidb;

import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GiftMsg$msg extends MessageMicro<GiftMsg$msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50, 56, 66, 74, 80, 88, 98}, new String[]{"giftid", "giftname", "recvuin", "recvnickname", "senduin", "sendnickname", "price", "orderid", "bgimage", "tianquanid", "level", LayoutAttrDefine.PADDING_TOP}, new Object[]{0L, "", 0L, "", 0L, "", 0L, "", "", 0L, 0, ""}, GiftMsg$msg.class);
    public final PBInt64Field giftid = PBField.initInt64(0);
    public final PBStringField giftname = PBField.initString("");
    public final PBInt64Field recvuin = PBField.initInt64(0);
    public final PBStringField recvnickname = PBField.initString("");
    public final PBInt64Field senduin = PBField.initInt64(0);
    public final PBStringField sendnickname = PBField.initString("");
    public final PBInt64Field price = PBField.initInt64(0);
    public final PBStringField orderid = PBField.initString("");
    public final PBStringField bgimage = PBField.initString("");
    public final PBInt64Field tianquanid = PBField.initInt64(0);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBStringField padding_top = PBField.initString("");
}
