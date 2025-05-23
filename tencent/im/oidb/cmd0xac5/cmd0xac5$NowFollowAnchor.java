package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$NowFollowAnchor extends MessageMicro<cmd0xac5$NowFollowAnchor> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_url;
    public final PBBytesField bytes_live_cover_url;
    public final PBBytesField bytes_live_url;
    public final PBBytesField bytes_nick_name;
    public final PBUInt32Field uint32_account_type;
    public final PBUInt32Field uint32_live_status;
    public final PBUInt64Field uint64_nowid;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_now_uid = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40, 50, 58, 64, 72}, new String[]{"uint64_uin", "uint64_now_uid", "bytes_nick_name", "bytes_head_url", "uint32_live_status", "bytes_live_url", "bytes_live_cover_url", "uint32_account_type", "uint64_nowid"}, new Object[]{0L, 0L, byteStringMicro, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0, 0L}, cmd0xac5$NowFollowAnchor.class);
    }

    public cmd0xac5$NowFollowAnchor() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick_name = PBField.initBytes(byteStringMicro);
        this.bytes_head_url = PBField.initBytes(byteStringMicro);
        this.uint32_live_status = PBField.initUInt32(0);
        this.bytes_live_url = PBField.initBytes(byteStringMicro);
        this.bytes_live_cover_url = PBField.initBytes(byteStringMicro);
        this.uint32_account_type = PBField.initUInt32(0);
        this.uint64_nowid = PBField.initUInt64(0L);
    }
}
