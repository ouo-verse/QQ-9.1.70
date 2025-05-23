package tencent.im.group_pro_proto.synclogic;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class synclogic$GuildNode extends MessageMicro<synclogic$GuildNode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56}, new String[]{"guild_id", "guild_code", "rpt_channel_nodes", "guild_name", "peer_source", "huge_flag", "face_seq"}, new Object[]{0L, 0L, null, ByteStringMicro.EMPTY, null, 0, 0L}, synclogic$GuildNode.class);
    public final PBUInt64Field guild_id = PBField.initUInt64(0);
    public final PBUInt64Field guild_code = PBField.initUInt64(0);
    public final PBRepeatMessageField<synclogic$ChannelNode> rpt_channel_nodes = PBField.initRepeatMessage(synclogic$ChannelNode.class);
    public final PBBytesField guild_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public synclogic$DirectMessageSource peer_source = new MessageMicro<synclogic$DirectMessageSource>() { // from class: tencent.im.group_pro_proto.synclogic.synclogic$DirectMessageSource
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField guild_name;
        public final PBBytesField member_name;
        public final PBUInt32Field member_type;
        public final PBBytesField nick_name;
        public final PBUInt64Field tiny_id = PBField.initUInt64(0);
        public final PBUInt64Field guild_id = PBField.initUInt64(0);

        static {
            String[] strArr = {INetChannelCallback.KEY_TINY_ID, "guild_id", "guild_name", "member_name", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "member_type"};
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48}, strArr, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro, 0}, synclogic$DirectMessageSource.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.guild_name = PBField.initBytes(byteStringMicro);
            this.member_name = PBField.initBytes(byteStringMicro);
            this.nick_name = PBField.initBytes(byteStringMicro);
            this.member_type = PBField.initUInt32(0);
        }
    };
    public final PBUInt32Field huge_flag = PBField.initUInt32(0);
    public final PBUInt64Field face_seq = PBField.initUInt64(0);
}
