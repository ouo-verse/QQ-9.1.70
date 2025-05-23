package tencent.im.common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$DirectMessageMember extends MessageMicro<nt_msg_common$DirectMessageMember> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField member_name;
    public final PBUInt32Field member_type;
    public final PBUInt32Field msg_notify_type;
    public final PBBytesField nick_name;
    public final PBBytesField source_guild_name;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0);
    public final PBUInt64Field source_guild_id = PBField.initUInt64(0);

    static {
        String[] strArr = {"uin", "tinyid", "source_guild_id", "source_guild_name", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "member_name", "msg_notify_type", "member_type"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 64}, strArr, new Object[]{0L, 0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0}, nt_msg_common$DirectMessageMember.class);
    }

    public nt_msg_common$DirectMessageMember() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.source_guild_name = PBField.initBytes(byteStringMicro);
        this.nick_name = PBField.initBytes(byteStringMicro);
        this.member_name = PBField.initBytes(byteStringMicro);
        this.msg_notify_type = PBField.initUInt32(0);
        this.member_type = PBField.initUInt32(0);
    }
}
