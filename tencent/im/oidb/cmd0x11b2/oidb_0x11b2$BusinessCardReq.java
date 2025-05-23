package tencent.im.oidb.cmd0x11b2;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x11b2$BusinessCardReq extends MessageMicro<oidb_0x11b2$BusinessCardReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 72}, new String[]{QCircleSchemeAttr.Detail.AVATAR_URL, "nickname", "contactInfo", "tag", "jump_url_ios", "jump_url_android", "jump_url_pc", "prompt", "is_forward"}, new Object[]{"", "", "", "", "", "", "", "", Boolean.FALSE}, oidb_0x11b2$BusinessCardReq.class);
    public final PBStringField avatar_url = PBField.initString("");
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField contactInfo = PBField.initString("");
    public final PBStringField tag = PBField.initString("");
    public final PBStringField jump_url_ios = PBField.initString("");
    public final PBStringField jump_url_android = PBField.initString("");
    public final PBStringField jump_url_pc = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
    public final PBBoolField is_forward = PBField.initBool(false);
}
