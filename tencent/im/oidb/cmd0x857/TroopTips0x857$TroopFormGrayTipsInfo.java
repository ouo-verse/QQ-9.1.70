package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopTips0x857$TroopFormGrayTipsInfo extends MessageMicro<TroopTips0x857$TroopFormGrayTipsInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_creator_nick;
    public final PBBytesField bytes_opt_bytes_url;
    public final PBBytesField bytes_rich_content;
    public final PBUInt64Field uint64_writer_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"uint64_writer_uin", "uint64_creator_uin", "bytes_rich_content", "bytes_opt_bytes_url", "bytes_creator_nick"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, byteStringMicro}, TroopTips0x857$TroopFormGrayTipsInfo.class);
    }

    public TroopTips0x857$TroopFormGrayTipsInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_rich_content = PBField.initBytes(byteStringMicro);
        this.bytes_opt_bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_creator_nick = PBField.initBytes(byteStringMicro);
    }
}
