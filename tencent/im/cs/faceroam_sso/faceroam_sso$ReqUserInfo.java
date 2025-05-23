package tencent.im.cs.faceroam_sso;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class faceroam_sso$ReqUserInfo extends MessageMicro<faceroam_sso$ReqUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"use_emoji_item"}, new Object[]{Boolean.FALSE}, faceroam_sso$ReqUserInfo.class);
    public final PBBoolField use_emoji_item = PBField.initBool(false);
}
