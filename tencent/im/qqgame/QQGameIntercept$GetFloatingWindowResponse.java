package tencent.im.qqgame;

import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQGameIntercept$GetFloatingWindowResponse extends MessageMicro<QQGameIntercept$GetFloatingWindowResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56}, new String[]{FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "title", "sub_title", "url", "icon", "name", "timeout"}, new Object[]{Boolean.FALSE, "", "", "", "", "", 0}, QQGameIntercept$GetFloatingWindowResponse.class);

    /* renamed from: ok, reason: collision with root package name */
    public final PBBoolField f436036ok = PBField.initBool(false);
    public final PBStringField title = PBField.initString("");
    public final PBStringField sub_title = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field timeout = PBField.initInt32(0);
}
