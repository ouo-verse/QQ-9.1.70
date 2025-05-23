package tencent.im.group_pro_proto.common;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$ContentHead extends MessageMicro<common$ContentHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "sub_type", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "msg_seq", "cnt_seq", ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME, "msg_meta"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L, ByteStringMicro.EMPTY}, common$ContentHead.class);
    public final PBUInt64Field msg_type = PBField.initUInt64(0);
    public final PBUInt64Field sub_type = PBField.initUInt64(0);
    public final PBUInt64Field random = PBField.initUInt64(0);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field cnt_seq = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
    public final PBBytesField msg_meta = PBField.initBytes(ByteStringMicro.EMPTY);
}
