package tencent.im.qqwallet;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QWalletHbPreGrab$QQHBRequest extends MessageMicro<QWalletHbPreGrab$QQHBRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"cgiName", "reqText", QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM, "enType", "reqBody"}, new Object[]{"", "", "", 0, ByteStringMicro.EMPTY}, QWalletHbPreGrab$QQHBRequest.class);
    public final PBStringField cgiName = PBField.initString("");
    public final PBStringField reqText = PBField.initString("");
    public final PBStringField random = PBField.initString("");
    public final PBEnumField enType = PBField.initEnum(0);
    public final PBBytesField reqBody = PBField.initBytes(ByteStringMicro.EMPTY);
}
