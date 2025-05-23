package tencent.im.troop_search_searchtab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.troop_search_userinfo.userinfo$UserInfo;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class searchtab$ReqBody extends MessageMicro<searchtab$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"user_info", "uint32_label_style"}, new Object[]{null, 0}, searchtab$ReqBody.class);
    public userinfo$UserInfo user_info = new userinfo$UserInfo();
    public final PBUInt32Field uint32_label_style = PBField.initUInt32(0);
}
