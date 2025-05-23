package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class YesGameInfoOuterClass$GameConfigOfHallInput extends MessageMicro<YesGameInfoOuterClass$GameConfigOfHallInput> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"icon_mic_on", "icon_mic_off", "icon_speaker_on", "icon_speaker_off", RedPacketInfoBase.ICON_EMOJI, "icon_profile", "icon_create_team", "color_bg", "color_bg_edit", "color_text_hint_edit", "color_text_edit", "icon_emoji_select"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", ""}, YesGameInfoOuterClass$GameConfigOfHallInput.class);
    public final PBStringField icon_mic_on = PBField.initString("");
    public final PBStringField icon_mic_off = PBField.initString("");
    public final PBStringField icon_speaker_on = PBField.initString("");
    public final PBStringField icon_speaker_off = PBField.initString("");
    public final PBStringField icon_emoji = PBField.initString("");
    public final PBStringField icon_profile = PBField.initString("");
    public final PBStringField icon_create_team = PBField.initString("");
    public final PBStringField color_bg = PBField.initString("");
    public final PBStringField color_bg_edit = PBField.initString("");
    public final PBStringField color_text_hint_edit = PBField.initString("");
    public final PBStringField color_text_edit = PBField.initString("");
    public final PBStringField icon_emoji_select = PBField.initString("");
}
