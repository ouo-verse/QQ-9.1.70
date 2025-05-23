package tencent.im.oidb.cmd0xac5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xac5$NowVideoFeed extends MessageMicro<cmd0xac5$NowVideoFeed> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_tnow_video_url;
    public final PBBytesField bytes_video_url;
    public final PBUInt32Field uint32_video_duration;
    public final PBUInt32Field uint32_view_times;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"bytes_cover_url", "bytes_video_url", "uint32_video_duration", "uint32_view_times", "bytes_tnow_video_url"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro}, cmd0xac5$NowVideoFeed.class);
    }

    public cmd0xac5$NowVideoFeed() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
        this.bytes_video_url = PBField.initBytes(byteStringMicro);
        this.uint32_video_duration = PBField.initUInt32(0);
        this.uint32_view_times = PBField.initUInt32(0);
        this.bytes_tnow_video_url = PBField.initBytes(byteStringMicro);
    }
}
