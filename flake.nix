{
  description = "A very basic flake";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs?ref=nixos-unstable";
  };

  outputs = { self, nixpkgs, ... }:
    let
      pkgs = import nixpkgs { system = "x86_64-linux"; };
    in
    {

      packages.x86_64-linux.hello = pkgs.hello;

      packages.x86_64-linux.default = pkgs.hello;

      devShells.x86_64-linux.default = pkgs.mkShell {
        packages = with pkgs; [
          gradle
          zulu17
        ];
        shellHook = ''
          export PATH="$PWD/gradle/wrapper:$PATH"
        '';
      };

  };
}
