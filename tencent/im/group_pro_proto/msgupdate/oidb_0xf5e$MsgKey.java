package tencent.im.group_pro_proto.msgupdate;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf5e$MsgKey extends MessageMicro<oidb_0xf5e$MsgKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, ProtocolDownloaderConstants.HEADER_C2C_MSG_TIME}, new Object[]{0L, 0L}, oidb_0xf5e$MsgKey.class);
    public final PBUInt64Field random = PBField.initUInt64(0);
    public final PBUInt64Field msg_time = PBField.initUInt64(0);
}
