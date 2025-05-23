package tencent.im.s2c.frdsysmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FrdSysMsg$FriendSysMsg extends MessageMicro<FrdSysMsg$FriendSysMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guild_src_url;
    public final PBBytesField bytes_paster_info;
    public FrdSysMsg$GroupInfoExt msg_group_ext = new FrdSysMsg$GroupInfoExt();
    public FrdSysMsg$InviteInfo msg_intite_info = new FrdSysMsg$InviteInfo();
    public FrdSysMsg$SchoolInfo msg_school_info = new FrdSysMsg$SchoolInfo();
    public final PBUInt32Field uint32_doubt_flag;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 106, 114, 402, 800}, new String[]{"msg_group_ext", "msg_intite_info", "msg_school_info", "bytes_guild_src_url", "bytes_paster_info", "uint32_doubt_flag"}, new Object[]{null, null, null, byteStringMicro, byteStringMicro, 0}, FrdSysMsg$FriendSysMsg.class);
    }

    public FrdSysMsg$FriendSysMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_guild_src_url = PBField.initBytes(byteStringMicro);
        this.bytes_paster_info = PBField.initBytes(byteStringMicro);
        this.uint32_doubt_flag = PBField.initUInt32(0);
    }
}
