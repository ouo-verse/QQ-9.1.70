package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$FriendMiscInfo extends MessageMicro<FrdSysMsg$FriendMiscInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_fromuin_nick"}, new Object[]{""}, FrdSysMsg$FriendMiscInfo.class);
    public final PBStringField str_fromuin_nick = PBField.initString("");
}
