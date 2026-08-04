# RTMU-ATSAssistMod_1.21.1

ATSAssistMod の 1.21.1 移植バージョン。**NeoForge / Fabric 両対応**。

地上子 (GroundUnit)、車上装置 (TrainController)、保安装置 (ATC / TASC / ATO / ATS-Ps ほか)。

## 構成

| 場所 | 中身 |
|---|---|
| `src/` | NeoForge 版 |
| `fabric/src/` | Fabric 版 |

Fabric 版は入口クラス (`jp.kaiz.atsassistmod.fabric.*`) だけが別で、それ以外のコードは共通です。

## 導入

[RTMU 本体](https://github.com/325-Sunnygo/RealTrainModUnofficial) が必要です。
本体と同じ `mods` フォルダへ入れてください。

## ビルド

**このリポジトリ単体ではビルドできません。** RTMU 本体のクラスを `compileOnly rootProject`
で参照しているためです。RTMU 本体を clone し、その `atsa/` サブプロジェクトとして置いてください
(Fabric 版は RTMU の Fabric ツリー側の `atsa/`)。

## Credits

All original design and code © the ATSAssistMod authors (**Kaiz_JP**).
This port preserves the original **GPL-3.0** license and author attribution.

1.21.1 への移植: 325-Sunnygo
