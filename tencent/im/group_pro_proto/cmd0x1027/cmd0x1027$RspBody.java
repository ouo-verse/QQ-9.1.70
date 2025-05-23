package tencent.im.group_pro_proto.cmd0x1027;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x1027$RspBody extends MessageMicro<cmd0x1027$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"msg", "cookie", "last_page"}, new Object[]{null, "", Boolean.FALSE}, cmd0x1027$RspBody.class);

    /* renamed from: msg, reason: collision with root package name */
    public final PBRepeatMessageField<cmd0x1027$UserInfo> f435940msg = PBField.initRepeatMessage(cmd0x1027$UserInfo.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBBoolField last_page = PBField.initBool(false);
}
