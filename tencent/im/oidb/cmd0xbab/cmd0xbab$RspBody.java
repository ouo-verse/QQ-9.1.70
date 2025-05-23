package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xbab$RspBody extends MessageMicro<cmd0xbab$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"user_get_rsp", "user_set_rsp", "group_get_rsp", "group_set_rsp"}, new Object[]{null, null, null, null}, cmd0xbab$RspBody.class);
    public cmd0xbab$UserGetRsp user_get_rsp = new cmd0xbab$UserGetRsp();
    public cmd0xbab$UserSetRsp user_set_rsp = new MessageMicro<cmd0xbab$UserSetRsp>() { // from class: tencent.im.oidb.cmd0xbab.cmd0xbab$UserSetRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0xbab$UserSetRsp.class);
    };
    public cmd0xbab$GroupGetRsp group_get_rsp = new cmd0xbab$GroupGetRsp();
    public cmd0xbab$GroupSetRsp group_set_rsp = new MessageMicro<cmd0xbab$GroupSetRsp>() { // from class: tencent.im.oidb.cmd0xbab.cmd0xbab$GroupSetRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], cmd0xbab$GroupSetRsp.class);
    };
}
