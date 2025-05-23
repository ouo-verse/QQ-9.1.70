package tencent.im.msg.hummer.resv;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class source_msg$ResvAttr extends MessageMicro<source_msg$ResvAttr> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guild_nick;
    public final PBBytesField bytes_richMsg2;
    public source_msg$CommentRefer comment_refer;
    public final PBUInt32Field uint32_ori_msgtype;
    public final PBRepeatField<Long> uint64_orig_uids;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"bytes_richMsg2", "uint32_ori_msgtype", "uint64_orig_uids", "bytes_guild_nick", "comment_refer"}, new Object[]{byteStringMicro, 0, 0L, byteStringMicro, null}, source_msg$ResvAttr.class);
    }

    public source_msg$ResvAttr() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_richMsg2 = PBField.initBytes(byteStringMicro);
        this.uint32_ori_msgtype = PBField.initUInt32(0);
        this.uint64_orig_uids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        this.bytes_guild_nick = PBField.initBytes(byteStringMicro);
        this.comment_refer = new source_msg$CommentRefer();
    }
}
