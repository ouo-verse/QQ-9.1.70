package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$ReqBody extends MessageMicro<cmd0xbab$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"user_get_req", "user_set_req", "group_get_req", "group_set_req"}, new Object[]{null, null, null, null}, cmd0xbab$ReqBody.class);
    public cmd0xbab$UserGetReq user_get_req = new cmd0xbab$UserGetReq();
    public cmd0xbab$UserSetReq user_set_req = new cmd0xbab$UserSetReq();
    public cmd0xbab$GroupGetReq group_get_req = new cmd0xbab$GroupGetReq();
    public cmd0xbab$GroupSetReq group_set_req = new cmd0xbab$GroupSetReq();
}
